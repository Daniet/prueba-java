package com.daniel.softmanager.mapper;

import com.daniel.softmanager.service.dto.SaleReportDTO;
import org.springframework.stereotype.Component;

@Component
public class ObjectToSaleReport implements IMapper<Object[], SaleReportDTO>{

    @Override
    public SaleReportDTO map(Object[] in) {
        SaleReportDTO saleReportDTO = new SaleReportDTO();
        saleReportDTO.setId(Long.valueOf((String) in[0]));
        saleReportDTO.setProduct((String) in[1]);
        saleReportDTO.setSale(Long.valueOf((String) in[2]));
        saleReportDTO.setTotal(Long.valueOf((String) in[3]));
        return saleReportDTO;
    }
}
