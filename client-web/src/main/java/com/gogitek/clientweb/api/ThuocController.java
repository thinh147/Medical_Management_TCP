package com.gogitek.clientweb.api;

import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.entity.Thuoc;
import com.gogitek.clientweb.service.thuoc.ThuocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thuoc")
@RequiredArgsConstructor
public class ThuocController {
    private final ThuocService thuocService;

    @GetMapping("/list")
    public ResponseEntity<?> getListCongDung(@RequestParam(defaultValue = "") String key){
        return ResponseEntity.ok(thuocService.getListThuoc(key));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCongDung(@RequestBody Thuoc thuoc){
        try{
            thuocService.updateThuoc(thuoc);
            return ResponseEntity.ok("Cập nhật thành công");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCongDung(@PathVariable Long id){
        try{
            thuocService.deleteThuoc(id);
            return ResponseEntity.ok("Xóa thành công");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
