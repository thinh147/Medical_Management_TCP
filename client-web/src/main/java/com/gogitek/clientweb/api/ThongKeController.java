package com.gogitek.clientweb.api;

import com.gogitek.clientweb.service.thongke.ThongKeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thong-ke")
@RequiredArgsConstructor
public class ThongKeController {
    private final ThongKeService thongKeService;

    @GetMapping()
    public ResponseEntity<?> getThongKeList(){
        return ResponseEntity.ok(thongKeService.thongKe());
    }
}
