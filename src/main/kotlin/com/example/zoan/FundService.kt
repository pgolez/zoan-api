package com.example.zoan

import com.example.zoan.http.CreateFundRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FundService {

    @Autowired
    lateinit var fundRepository: FundRepository

    @Autowired
    lateinit var fundFactory: FundFactory

    @Autowired
    lateinit var loanerRepository: LoanerRepository

    fun createFund(params: CreateFundParams): Fund {
        try {
            val fund = fundFactory.buildFundFromParams(params)
            fundRepository.save(fund)
            return fund
        } catch (exception: InsufficientLoanerBalanceException) {
            throw FundCreationException(exception)
        }

    }
}

data class CreateFundParams(val owners: List<CreateFundRequest.CreateFundRequestOwnerFragment>)
