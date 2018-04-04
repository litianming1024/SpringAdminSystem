package cn.godbol.service.impl;

import cn.godbol.domain.Appointment;
import cn.godbol.domain.repository.AppointmentRepository;
import cn.godbol.service.api.AppointmentService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:44.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    WxMpService wxMpService;

    @Override
    public JpaRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public <S extends Appointment> S update(Long aLong, S entity) {

        return save(entity);
    }

    @Override
    public <S extends Appointment> S save(S entity) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(entity.getApply().getResume().getUser().getOpenId()).templateId("ojLd9VlA4OkQLM5ddkhxU4x_bKMa1NWdQuf8BaiG7Og").build();
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH时mm分");
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("interviewTime", format.format(entity.getInterviewTime().getTime())));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("place", entity.getPlace()));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("info", "若不能到场，请致电"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            entity.setPush(true);
        } catch (WxErrorException e) {
            entity.setPush(false);
            e.printStackTrace();
        }
        return getRepository().save(entity);
    }

    @Override
    public Page<Appointment> findAppointmentByApplyStatus(Collection<Integer> applyStatus, Pageable pageable) {
        return appointmentRepository.findAppointmentByApplyStatus(applyStatus, pageable);
    }

    @Override
    public Appointment findLatest(Long id) {
        return appointmentRepository.findByApplyIdOrderByApplyDesc(id);
    }

    @Override
    public Appointment findByApplyIdAndInterviewType(Long applyId, Integer interviewType) {
        return appointmentRepository.findByApplyIdAndInterviewType(applyId, interviewType);
    }

    public Page<Appointment> findAppointmentsByInterviewTypeAndStatus(int interviewType, int status, Pageable pageable) {
        return appointmentRepository.findAppointmentsByInterviewTypeAndStatus(interviewType, status, pageable);
    }

    @Override
    public Page<Appointment> findAppointmentsByStatus(Collection<Integer> status, Pageable pageable) {
        return appointmentRepository.findAppointmentsByStatusIn(status, pageable);
    }

    @Override
    public long countAllByStatus(Integer status) {
        return appointmentRepository.countAllByStatus(status);
    }

    @Override
    public long countAllByStatus(Collection<Integer> status) {
        return appointmentRepository.countAllByStatus(status);
    }
}
