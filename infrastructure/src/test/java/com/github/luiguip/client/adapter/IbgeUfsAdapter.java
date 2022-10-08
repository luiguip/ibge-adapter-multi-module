package com.github.luiguip.client.adapter;

import com.github.luiguip.client.IbgeUfResponse;
import com.github.luiguip.client.IbgeUfsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class IbgeUfsAdapter {

    private final IbgeUfsClient ufsClient;

    public Optional<IbgeUfResponse[]> getAll() {
        return ufsClient.getAll();
    }

}
