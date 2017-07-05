package com.sdj.rent.services;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;

import com.sdj.rent.models.data.BankOffer;

public class BankOfferService extends BaseService {

	public List<BankOffer> list() {
		return  BankOffer.dao.find("select * from bank_offer");
	}

	@Before(Tx.class)
	public boolean add(BankOffer bankOffer) {
		try {
			if (bankOffer.save()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Before(Tx.class)
	public boolean update(BankOffer bankOffer) {
		try {
			if (bankOffer.update()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Before(Tx.class)
	public boolean delete(String id) {
		try {
			if (BankOffer.dao.deleteById(id)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
