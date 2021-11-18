package net.evry.toll.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TollCalService {
    int getTollFee(String vehicle, List<LocalDateTime> dates);
}
