package com.example.restapi.service;

import com.example.restapi.model.Advertiser;
import com.example.restapi.model.Bill;
import com.example.restapi.model.BillDto;
import com.example.restapi.repository.AdvertiserRepository;
import com.example.restapi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImp implements BillService{

    private BillRepository billRepository;

    @Autowired
    public BillServiceImp (BillRepository billRepository){
        this.billRepository=billRepository;
    }


    @Override
    public List<BillDto> getAll () {
        List<Bill> bills =billRepository.findAll ();
        return bills.stream().map(Bill::toBillDto).collect( Collectors.toList());


    }

    @Override
    public BillDto getBillById (int id) throws Exception {
        if(billRepository.findById ( id ).isPresent ()) {
            return billRepository.findById ( id ).get ().toBillDto ();
        }else {
            throw new Exception("Bill By this id " + id + "does not exist");
        }
    }

    @Override
    public BillDto createBill (BillDto billDto) {
        Bill bill=billDto.toBill ();
        return billRepository.save ( bill ).toBillDto ();
    }

    @Override
    public BillDto updateBill (int id , BillDto billDto) {
        if(billRepository.findById ( id ).isPresent ()) {
            Bill bill = billRepository.findById ( id ).get ();
            bill.setBillAmount ( billDto.getBillAmount () );
            bill.setBillRate ( billDto.getBillRate () );
            bill.setBillStatus ( billDto.getBillStatus () );
            bill.setDataIssued ( billDto.getDataIssued () );

            return billRepository.save ( bill ).toBillDto ();
        }else {
            Bill bill=billDto.toBill ();
            return billRepository.save ( bill ).toBillDto ();
        }



    }

    @Override
    public void deleteBillById (int id) throws Exception {
        if(billRepository.findById ( id ).isPresent ()) {
            billRepository.delete ( billRepository.findById ( id ).get () );
        }else {
            throw new Exception("Advertiser By this id " + id + "does not exist");
        }
    }
}
