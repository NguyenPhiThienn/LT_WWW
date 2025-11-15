package iuh.fit.se.be.mappers;

import iuh.fit.se.be.dtos.NhaCungCapDTO;
import iuh.fit.se.be.entities.NhaCungCap;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NhaCungCapMapper {
    NhaCungCapDTO toDTO(NhaCungCap entity);
    NhaCungCap toEntity(NhaCungCapDTO dto);
}
