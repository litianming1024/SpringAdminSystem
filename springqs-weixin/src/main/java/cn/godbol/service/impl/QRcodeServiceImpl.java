package cn.godbol.service.impl;

import cn.godbol.domain.QRcode;
import cn.godbol.domain.repository.QRcodeRepository;
import cn.godbol.service.api.QRcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-03-24 下午9:18.
 */
@Service
public class QRcodeServiceImpl implements QRcodeService {

    @Autowired
    QRcodeRepository qRcodeRepository;

    @Override
    public JpaRepository<QRcode, Long> getRepository() {
        return qRcodeRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}
