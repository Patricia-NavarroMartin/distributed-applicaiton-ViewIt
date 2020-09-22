package entities.inherited;

import entities.Product;
import enumerations.TicketType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("ticket")
public class Ticket extends Product {

    @Column (name = "ticket_type")
    @Enumerated (EnumType.STRING) 
    private TicketType ticketType;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
    
    
}
