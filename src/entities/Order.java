package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Client client;
	private Date momment;
	private OrderStatus status;
	private List<OrderItem> itens = new ArrayList<>();

	public Order() {
	}

	public Order(Client client,OrderStatus status,Date momment) {
		this.client = client;
		this.status = status;
		this.momment = momment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getItens(){
		return itens;
	}

	public void addOrderItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeOrderItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMomment() {
		return momment;
	}

	public void setMomment(Date momment) {
		this.momment = momment;
	}

	public Double total() {
		double total = 0;
		for (OrderItem c : itens) {
			total += c.subTotal();
		}
		return total;
	}
	
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Order moment: ");
    	sb.append(sfd.format(momment) + "\n");
    	sb.append("Order status:");
    	sb.append(status + "\n");
    	sb.append("Client: ");
    	sb.append(client + "\n");
    	sb.append("Order items:\n");
    	for (OrderItem item : itens) {
    		sb.append(item + "\n");
    	}
    	sb.append("Total price:");
    	sb.append(String.format("%.2f", total()));
    	return sb.toString();
    }
}
