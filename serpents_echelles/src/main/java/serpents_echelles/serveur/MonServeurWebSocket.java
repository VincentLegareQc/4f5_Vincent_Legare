package serpents_echelles.serveur;

import ntro.debogage.J;
import ntro.web_socket.ServeurWebSocket;

public class MonServeurWebSocket extends ServeurWebSocket {

	public MonServeurWebSocket(int port) {
		super(port);
		J.appel(this);
	}

}