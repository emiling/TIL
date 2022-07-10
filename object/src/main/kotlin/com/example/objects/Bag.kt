package com.example.objects

data class Bag(
    private var amount: Long = 0,
    private val invitation: Invitation?,
    private var ticket: Ticket?
){
    private fun hasInvitation(): Boolean = (invitation != null)
    private fun hasTicket(): Boolean = (ticket != null)

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long){
        this.amount += amount
    }

    fun hold(ticket: Ticket): Long{
        return if(hasInvitation()){
            this.ticket = ticket
            0
        }else{
            minusAmount(ticket.fee)
            this.ticket = ticket
            ticket.fee
        }
    }
}