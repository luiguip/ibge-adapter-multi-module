package com.github.luiguip.infrastructure.mapper;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.infrastructure.client.response.IbgeUfResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T18:15:49-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (N/A)"
)
@Component
public class IbgeUfMapperImpl implements IbgeUfMapper {

    @Override
    public List<IbgeUf> toModel(List<IbgeUfResponse> ibgeUfResponse) {
        if ( ibgeUfResponse == null ) {
            return null;
        }

        List<IbgeUf> list = new ArrayList<IbgeUf>( ibgeUfResponse.size() );
        for ( IbgeUfResponse ibgeUfResponse1 : ibgeUfResponse ) {
            list.add( ibgeUfResponseToIbgeUf( ibgeUfResponse1 ) );
        }

        return list;
    }

    protected IbgeUf ibgeUfResponseToIbgeUf(IbgeUfResponse ibgeUfResponse) {
        if ( ibgeUfResponse == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        String abbreviation = null;

        id = ibgeUfResponse.id();
        name = ibgeUfResponse.name();
        abbreviation = ibgeUfResponse.abbreviation();

        IbgeUf ibgeUf = new IbgeUf( id, name, abbreviation );

        return ibgeUf;
    }
}
