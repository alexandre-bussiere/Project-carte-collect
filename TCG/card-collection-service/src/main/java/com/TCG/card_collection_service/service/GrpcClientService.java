import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.grpc.YourGrpcServiceGrpc;
import com.example.grpc.YourGrpcServiceGrpc.YourGrpcServiceBlockingStub;
import com.example.grpc.YourRequest;
import com.example.grpc.YourResponse;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final YourGrpcServiceBlockingStub grpcServiceStub;

    public GrpcClientService() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090) // Adresse et port de votre service gRPC
                .usePlaintext()
                .build();

        this.grpcServiceStub = YourGrpcServiceGrpc.newBlockingStub(channel);
    }

    public String callGrpcService(String parameter) {
        YourRequest request = YourRequest.newBuilder()
                .setParameter(parameter)
                .build();

        YourResponse response = grpcServiceStub.CardExchange(request); // Appel de la méthode gRPC
        return response.getResult(); // Retourne le résultat de la réponse
    }
}
