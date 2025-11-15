package iuh.fit.se.be.mappers;


import iuh.fit.se.be.dtos.DienThoaiDTO;
import iuh.fit.se.be.entities.DienThoai;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DienThoaiMapper {

    @Mapping(source = "nhaCungCap.maNCC", target = "maNCC")
    @Mapping(source = "nhaCungCap.tenNhaCC", target = "tenNhaCC")
    DienThoaiDTO toDTO(DienThoai entity);

    @InheritInverseConfiguration
    DienThoai toEntity(DienThoaiDTO dto);
}