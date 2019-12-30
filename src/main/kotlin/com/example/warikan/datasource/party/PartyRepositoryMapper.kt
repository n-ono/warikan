package com.example.warikan.datasource.party

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import java.time.LocalDateTime

@Mapper
interface PartyRepositoryMapper {
    @Insert(
        """
        INSERT INTO parties
            (party_id, party_name, party_holding_date_time)
        VALUES
            (#{partyId}, #{partyName}, #{partyHoldingDateTime})
    """
    )
    fun schedule(partyId: String, partyName: String, partyHoldingDateTime: LocalDateTime)
}
