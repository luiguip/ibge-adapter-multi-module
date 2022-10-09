package com.github.luiguip.infrastructure.adapter;

import com.github.luiguip.infrastructure.mapper.IbgeUfMapper;
import com.github.luiguip.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.domain.IbgeUf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IbgeUfsAdapter {

    private final IbgeUfMapper mapper;
    private final IbgeUfsClient client;

    public List<IbgeUf> getAll() {
        var ufs = client.getAll();
        return mapper.toModel(ufs);
    }

}
