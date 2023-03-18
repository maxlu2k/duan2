package com.qlmh.datn_qlmh.services;


import com.qlmh.datn_qlmh.entities.AccountEntity;


import java.util.List;

public interface AccountService {

    public AccountEntity create(AccountEntity account);
    public AccountEntity update(AccountEntity account);
    public List<AccountEntity> getAll();
    public AccountEntity getByUsername(String id);
    public List<AccountEntity> listAdmin();

}
