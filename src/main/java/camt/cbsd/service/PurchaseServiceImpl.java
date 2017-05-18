package camt.cbsd.service;

import camt.cbsd.dao.PurchaseDao;
import camt.cbsd.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pariy on 5/18/2017.
 */

@Service
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    PurchaseDao purchaseDao;

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return purchaseDao.addPurchase(purchase);
    }
}
