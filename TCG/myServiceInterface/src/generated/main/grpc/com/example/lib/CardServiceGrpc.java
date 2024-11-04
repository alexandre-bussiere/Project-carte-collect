package com.example.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Définition du service gRPC
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: myService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CardServiceGrpc {

  private CardServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.CardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.lib.CardExchangeRequest,
      com.example.lib.CardExchangeResponse> getCardExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CardExchange",
      requestType = com.example.lib.CardExchangeRequest.class,
      responseType = com.example.lib.CardExchangeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.lib.CardExchangeRequest,
      com.example.lib.CardExchangeResponse> getCardExchangeMethod() {
    io.grpc.MethodDescriptor<com.example.lib.CardExchangeRequest, com.example.lib.CardExchangeResponse> getCardExchangeMethod;
    if ((getCardExchangeMethod = CardServiceGrpc.getCardExchangeMethod) == null) {
      synchronized (CardServiceGrpc.class) {
        if ((getCardExchangeMethod = CardServiceGrpc.getCardExchangeMethod) == null) {
          CardServiceGrpc.getCardExchangeMethod = getCardExchangeMethod =
              io.grpc.MethodDescriptor.<com.example.lib.CardExchangeRequest, com.example.lib.CardExchangeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CardExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.lib.CardExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.lib.CardExchangeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CardServiceMethodDescriptorSupplier("CardExchange"))
              .build();
        }
      }
    }
    return getCardExchangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CardServiceStub>() {
        @java.lang.Override
        public CardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CardServiceStub(channel, callOptions);
        }
      };
    return CardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CardServiceBlockingStub>() {
        @java.lang.Override
        public CardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CardServiceBlockingStub(channel, callOptions);
        }
      };
    return CardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CardServiceFutureStub>() {
        @java.lang.Override
        public CardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CardServiceFutureStub(channel, callOptions);
        }
      };
    return CardServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Définition du service gRPC
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Méthode CardExchange pour échanger une carte entre joueurs
     * </pre>
     */
    default void cardExchange(com.example.lib.CardExchangeRequest request,
        io.grpc.stub.StreamObserver<com.example.lib.CardExchangeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCardExchangeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CardService.
   * <pre>
   * Définition du service gRPC
   * </pre>
   */
  public static abstract class CardServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CardServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CardService.
   * <pre>
   * Définition du service gRPC
   * </pre>
   */
  public static final class CardServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CardServiceStub> {
    private CardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CardServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Méthode CardExchange pour échanger une carte entre joueurs
     * </pre>
     */
    public void cardExchange(com.example.lib.CardExchangeRequest request,
        io.grpc.stub.StreamObserver<com.example.lib.CardExchangeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCardExchangeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CardService.
   * <pre>
   * Définition du service gRPC
   * </pre>
   */
  public static final class CardServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CardServiceBlockingStub> {
    private CardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CardServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Méthode CardExchange pour échanger une carte entre joueurs
     * </pre>
     */
    public com.example.lib.CardExchangeResponse cardExchange(com.example.lib.CardExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCardExchangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CardService.
   * <pre>
   * Définition du service gRPC
   * </pre>
   */
  public static final class CardServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CardServiceFutureStub> {
    private CardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CardServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Méthode CardExchange pour échanger une carte entre joueurs
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.lib.CardExchangeResponse> cardExchange(
        com.example.lib.CardExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCardExchangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CARD_EXCHANGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CARD_EXCHANGE:
          serviceImpl.cardExchange((com.example.lib.CardExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.example.lib.CardExchangeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCardExchangeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.lib.CardExchangeRequest,
              com.example.lib.CardExchangeResponse>(
                service, METHODID_CARD_EXCHANGE)))
        .build();
  }

  private static abstract class CardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.lib.CardExchangeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CardService");
    }
  }

  private static final class CardServiceFileDescriptorSupplier
      extends CardServiceBaseDescriptorSupplier {
    CardServiceFileDescriptorSupplier() {}
  }

  private static final class CardServiceMethodDescriptorSupplier
      extends CardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CardServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CardServiceFileDescriptorSupplier())
              .addMethod(getCardExchangeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
