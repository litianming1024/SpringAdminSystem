package cn.godbol.domain.mapper;

import cn.godbol.domain.QRcode;
import cn.godbol.domain.dto.QRcodeDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 2018-03-24 下午4:51.
 */
@Mapper(componentModel = "spring", uses = {})
public interface QRcodeMapper {
    QRcodeDTO qrCodeToQRcodeDTO(QRcode qrCode);

    Collection<QRcodeDTO> qrCodesToQRcodeDTOs(Collection<QRcode> qrCodes);

    QRcode qrCodeDTOToQRcode(QRcodeDTO qrCodeDTO);

    Collection<QRcode> qrCodeDTOsToQRcodes(Collection<QRcodeDTO> qrCodeDTOs);
}
