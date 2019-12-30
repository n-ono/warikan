package com.example.warikan.api.bill

import com.example.warikan.domain.bill.TotalBillingAmount
import com.example.warikan.domain.party.PartyId
import com.example.warikan.service.bill.BillService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bill/issue")
@Api("請求書を発行する")
class BillIssueApi(private val billService: BillService) {
    @GetMapping
    @ApiOperation("請求書を発行する")
    fun issue(
        @ApiParam(value = "飲み会の識別子", defaultValue = "") @RequestParam partyId: String,
        @ApiParam(value = "請求金額", defaultValue = "") @RequestParam totalBillingAmount: Int
    ) = billService.issue(PartyId(partyId), TotalBillingAmount(totalBillingAmount))
}
