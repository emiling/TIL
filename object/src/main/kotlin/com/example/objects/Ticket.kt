package com.example.objects

data class Ticket(
    val fee: Long
)

data class TicketOffice(
    var amount: Long,
    val tickets: MutableList<Ticket> = mutableListOf()
){
    fun getTicket(): Ticket = tickets[0]
    fun minusAmount(amount: Long){
        this.amount -= amount
    }
    fun plusAmount(amount: Long){
        this.amount += amount
    }

    fun sellTicketTo(audience: Audience){
        val ticket = getTicket()
        val profit = audience.buy(ticket)
        plusAmount(profit)
    }
}

data class TicketSeller(
    private val ticketOffice: TicketOffice
){
    fun sellTo(audience: Audience){
        ticketOffice.sellTicketTo(audience)
    }
}