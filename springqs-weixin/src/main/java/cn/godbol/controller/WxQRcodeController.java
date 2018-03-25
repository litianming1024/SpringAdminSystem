package cn.godbol.controller;

import cn.godbol.domain.QRcode;
import cn.godbol.domain.dto.QRcodeDTO;
import cn.godbol.domain.mapper.QRcodeMapper;
import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.QRcodeService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by li on 2018-03-24 下午4:21.
 */
@RestController
@RequestMapping("/api/wechat/QRcode")
public class WxQRcodeController implements DefaultCrudController<QRcode, Long, QueryParam, QRcodeDTO>{

    @Autowired
    QRcodeMapper qRcodeMapper;

    @Autowired
    QRcodeService qRcodeService;

    @Autowired
    WxMpService wxMpService;

    @Override
    public CrudService<QRcode, Long> getService() {
        return qRcodeService;
    }

    @Override
    @PostMapping
    public ResponseMessage create(@RequestBody QRcodeDTO qRcodeDTO) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, WxErrorException {
        QRcode qRcode = DTOToEntity(qRcodeDTO);
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(qRcode.getSceneStr(), qRcode.getExpireSeconds());
        qRcode.setCreateTime(Calendar.getInstance());
        qRcode.setTicket(ticket.getTicket());
        qRcode.setExpireSeconds(ticket.getExpireSeconds());
        qRcode = qRcodeService.save(qRcode);
        return ResponseMessage.ok(qRcode);
    }

    @Override
    public QRcode DTOToEntity(QRcodeDTO qRcodeDTO) {
        return qRcodeMapper.qrCodeDTOToQRcode(qRcodeDTO);
    }

    @Override
    public QRcodeDTO entityToDTO(QRcode qRcode) {
        return qRcodeMapper.qrCodeToQRcodeDTO(qRcode);
    }
}
