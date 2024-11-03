import com.TCG.card_collection_service.service.GrpcClientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class GrpcController {

    private final GrpcClientService grpcClientService;

    @Autowired
    public GrpcController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/call-grpc")
    public String callGrpcService(@RequestParam String parameter) {
        return grpcClientService.callGrpcService(parameter);
    }
}
