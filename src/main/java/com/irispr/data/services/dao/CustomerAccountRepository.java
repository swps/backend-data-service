package com.irispr.data.services.dao;

import com.irispr.data.models.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by wendel.schultz on 9/19/15.
 */
@Repository
@RepositoryRestResource(path = "customer_accounts", collectionResourceRel = "customer_accounts")
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String>{
}
