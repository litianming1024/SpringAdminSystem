package cn.godbol.domain.repository;

import cn.godbol.domain.QRcode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by li on 2018-03-24 下午9:05.
 */
public interface QRcodeRepository extends JpaRepository<QRcode, Long> {
    QRcode findByTicket(String ticket);
}
