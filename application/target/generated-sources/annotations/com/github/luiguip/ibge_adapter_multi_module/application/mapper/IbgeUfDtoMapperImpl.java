package com.github.luiguip.ibge_adapter_multi_module.application.mapper;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T19:01:22-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class IbgeUfDtoMapperImpl implements IbgeUfDtoMapper {

    @Override
    public List<IbgeUfDto> toDto(List<IbgeUf> ufs) {
        if ( ufs == null ) {
            return null;
        }

        List<IbgeUfDto> list = new ArrayList<IbgeUfDto>( ufs.size() );
        for ( IbgeUf ibgeUf : ufs ) {
            list.add( ibgeUfToIbgeUfDto( ibgeUf ) );
        }

        return list;
    }

    protected IbgeUfDto ibgeUfToIbgeUfDto(IbgeUf ibgeUf) {
        if ( ibgeUf == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        String abbreviation = null;

        id = ibgeUf.id();
        name = ibgeUf.name();
        abbreviation = ibgeUf.abbreviation();

        IbgeUfDto ibgeUfDto = new IbgeUfDto( id, name, abbreviation );

        return ibgeUfDto;
    }
}
