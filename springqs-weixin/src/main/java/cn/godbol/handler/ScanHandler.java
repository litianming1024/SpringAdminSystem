package cn.godbol.handler;

import cn.godbol.domain.*;
import cn.godbol.domain.repository.AppointmentRepository;
import cn.godbol.domain.repository.QRcodeRepository;
import cn.godbol.domain.repository.ResumeRepository;
import cn.godbol.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class ScanHandler extends AbstractHandler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    QRcodeRepository qRcodeRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    WxMpService wxMpService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        String key = wxMessage.getEventKey();
        if (key.equals("signup")) {
            //用户可能存在什么资料都没有的情况
            User user = userRepository.findByOpenId(wxMessage.getOpenId());
            if (user == null) return null;
            Collection<Apply> applies = resumeRepository.findByUserId(user.getId()).getApplies();
            Appointment latestAppointment = null;
            for (Apply apply: applies) {
                List<Appointment> appointments = apply.getAppointments();
                appointments.sort(new Comparator<Appointment>() {
                    @Override
                    public int compare(Appointment o1, Appointment o2) {
                        return o2.getInterviewType() - o1.getInterviewType();
                    }
                });
                if (appointments.get(0).getInterviewType() == 0) {
                    latestAppointment = appointments.get(0);
                    break;
                }
            }
            if (latestAppointment == null) return null;

            latestAppointment.setStatus(1);
            latestAppointment.setPresentTime(Calendar.getInstance());
            latestAppointment = appointmentRepository.save(latestAppointment);
            String ticket = wxMessage.getTicket();
            QRcode qRcode = qRcodeRepository.findByTicket(ticket);
            qRcode.setCount(qRcode.getCount() + 1);
            qRcode = qRcodeRepository.save(qRcode);

            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(wxMessage.getFromUser()).templateId("dNgLuEFfROy5fZdlRbb-5MEams_3oKybrGxqOVvaVtY").build();
            SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH时mm分");
            templateMessage.addWxMpTemplateData(new WxMpTemplateData("interviewTime", format.format(latestAppointment.getInterviewTime().getTime())));
            templateMessage.addWxMpTemplateData(new WxMpTemplateData("place", latestAppointment.getPlace()));
          templateMessage.addWxMpTemplateData(new WxMpTemplateData("presentTime", format.format(latestAppointment.getPresentTime().getTime())));
          wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }
        return null;
    }
}
