package com.example.warikan.datasource.member

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface MemberRepositoryMapper {
    @Insert(
        """
        INSERT INTO members
            (member_id, party_id, member_name, payment_type, member_type)
        VALUES
            (#{memberId}, #{partyId}, #{memberName}, #{paymentType}, #{memberType})
    """
    )
    fun participate(memberId: String, partyId: String, memberName: String, paymentType: String, memberType: String)

    @Select(
        """
        SELECT
            member_id, party_id, member_name, payment_type, member_type
        FROM
            members
        WHERE
            member_id = #{memberId}
    """
    )
    fun findById(memberId: String): MemberDao

    @Select(
        """
        SELECT
            member_id, party_id, member_name, payment_type, member_type
        FROM
            members
        WHERE
            party_id = #{partyId}
    """
    )
    fun allMembers(partyId: String): List<MemberDao>
}
