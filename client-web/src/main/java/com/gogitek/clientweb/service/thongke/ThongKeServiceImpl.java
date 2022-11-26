package com.gogitek.clientweb.service.thongke;

import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.entity.Thuoc;
import com.gogitek.clientweb.entity.dto.ThongKe;
import com.gogitek.clientweb.service.congdung.CongDungService;
import com.gogitek.clientweb.service.thuoc.ThuocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongKeServiceImpl implements ThongKeService{
    private final ThuocService thuocService;
    private final CongDungService congDungService;
    @Override
    public List<ThongKe> thongKe() {
        List<CongDung> congDungList = congDungService.getListCongDungByKey("");
        Map<Long, String> congDungIdNameMap = congDungList.stream().collect(Collectors.toMap(CongDung::getLongId, CongDung::getMaCongDung));
        List<Thuoc> thuocList = thuocService.getListThuoc("");
        Map<Long, Long> mapCongDungIdAndThuocCount = thuocList.stream().collect(Collectors.groupingBy(Thuoc::getCongDungId, Collectors.counting()));
        List<ThongKe> thongKeList = new ArrayList<>();
        for(Long k : mapCongDungIdAndThuocCount.keySet()){
            ThongKe thongKe = new ThongKe();
            thongKe.setCongDungName(congDungIdNameMap.get(k));
            thongKe.setSoLuongThuoc(Math.toIntExact(mapCongDungIdAndThuocCount.get(k)));
            thongKeList.add(thongKe);
        }
        return thongKeList;
    }
}
