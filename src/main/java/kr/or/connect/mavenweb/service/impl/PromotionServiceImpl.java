package kr.or.connect.mavenweb.service.impl;

import kr.or.connect.mavenweb.dao.PromotionDao;
import kr.or.connect.mavenweb.dto.Promotion;
import kr.or.connect.mavenweb.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    PromotionDao promotionDao;

    @Override
    public List<Promotion> getPromotionResponse() {
        return promotionDao.select();
    }
}
