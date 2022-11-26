package com.gogitek.clientweb.api;

import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.service.congdung.CongDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cong-dung")
@RequiredArgsConstructor
public class CongDungController {
    private final CongDungService congDungService;

    @GetMapping("/list")
    public ResponseEntity<?> getListCongDung(@RequestParam(defaultValue = "") String key){
        return ResponseEntity.ok(congDungService.getListCongDungByKey(key));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCongDung(@RequestBody CongDung congDung){
        try{
            congDungService.updateCongDung(congDung);
            return ResponseEntity.ok("Cập nhật thành công");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCongDung(@PathVariable Long id){
        try{
            congDungService.deleteCongDung(id);
            return ResponseEntity.ok("Xóa thành công");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
