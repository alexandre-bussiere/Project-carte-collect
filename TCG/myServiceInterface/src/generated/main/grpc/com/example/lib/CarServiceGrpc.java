package com.example.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service pour les voitures
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: myService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CarServiceGrpc {

  private CarServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.CarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.lib.Empty,
      com.example.lib.CarReply> getGetRandomCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRandomCar",
      requestType = com.example.lib.Empty.class,
      responseType = com.example.lib.CarReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.lib.Empty,
      com.example.lib.CarReply> getGetRandomCarMethod() {
    io.grpc.MethodDescriptor<com.example.lib.Empty, com.example.lib.CarReply> getGetRandomCarMethod;
    if ((getGetRandomCarMethod = CarServiceGrpc.getGetRandomCarMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getGetRandomCarMethod = CarServiceGrpc.getGetRandomCarMethod) == null) {
          CarServiceGrpc.getGetRandomCarMethod = getGetRandomCarMethod =
              io.grpc.MethodDescriptor.<com.example.lib.Empty, com.example.lib.CarReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRandomCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.lib.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.lib.CarReply.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("GetRandomCar"))
              .build();
        }
      }
    }
    return getGetRandomCarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceStub>() {
        @java.lang.Override
        public CarServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceStub(channel, callOptions);
        }
      };
    return CarServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceBlockingStub>() {
        @java.lang.Override
        public CarServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceBlockingStub(channel, callOptions);
        }
      };
    return CarServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceFutureStub>() {
        @java.lang.Override
        public CarServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceFutureStub(channel, callOptions);
        }
      };
    return CarServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service pour les voitures
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getRandomCar(com.example.lib.Empty request,
        io.grpc.stub.StreamObserver<com.example.lib.CarReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRandomCarMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CarService.
   * <pre>
   * Service pour les voitures
   * </pre>
   */
  public static abstract class CarServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CarServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CarService.
   * <pre>
   * Service pour les voitures
   * </pre>
   */
  public static final class CarServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CarServiceStub> {
    private CarServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRandomCar(com.example.lib.Empty request,
        io.grpc.stub.StreamObserver<com.example.lib.CarReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRandomCarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CarService.
   * <pre>
   * Service pour les voitures
   * </pre>
   */
  public static final class CarServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CarServiceBlockingStub> {
    private CarServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.lib.CarReply getRandomCar(com.example.lib.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRandomCarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CarService.
   * <pre>
   * Service pour les voitures
   * </pre>
   */
  public static final class CarServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CarServiceFutureStub> {
    private CarServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.lib.CarReply> getRandomCar(
        com.example.lib.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRandomCarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RANDOM_CAR = 0;

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
        case METHODID_GET_RANDOM_CAR:
          serviceImpl.getRandomCar((com.example.lib.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.lib.CarReply>) responseObserver);
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
          getGetRandomCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.lib.Empty,
              com.example.lib.CarReply>(
                service, METHODID_GET_RANDOM_CAR)))
        .build();
  }

  private static abstract class CarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.lib.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarService");
    }
  }

  private static final class CarServiceFileDescriptorSupplier
      extends CarServiceBaseDescriptorSupplier {
    CarServiceFileDescriptorSupplier() {}
  }

  private static final class CarServiceMethodDescriptorSupplier
      extends CarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CarServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarServiceFileDescriptorSupplier())
              .addMethod(getGetRandomCarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
