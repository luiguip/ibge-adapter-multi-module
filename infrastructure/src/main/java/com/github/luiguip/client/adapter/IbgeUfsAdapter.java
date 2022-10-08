package com.github.luiguip.client.adapter;

import com.github.luiguip.client.IbgeUfMapper;
import com.github.luiguip.client.IbgeUfsClient;
import com.github.luiguip.model.IbgeUf;
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
