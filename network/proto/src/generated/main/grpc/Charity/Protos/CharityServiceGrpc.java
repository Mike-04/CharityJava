package Charity.Protos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: charity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CharityServiceGrpc {

  private CharityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Charity.Protos.CharityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.LoginUserRequest,
      Charity.Protos.Charity.LoginUserResponse> getLoginUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginUser",
      requestType = Charity.Protos.Charity.LoginUserRequest.class,
      responseType = Charity.Protos.Charity.LoginUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.LoginUserRequest,
      Charity.Protos.Charity.LoginUserResponse> getLoginUserMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.LoginUserRequest, Charity.Protos.Charity.LoginUserResponse> getLoginUserMethod;
    if ((getLoginUserMethod = CharityServiceGrpc.getLoginUserMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getLoginUserMethod = CharityServiceGrpc.getLoginUserMethod) == null) {
          CharityServiceGrpc.getLoginUserMethod = getLoginUserMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.LoginUserRequest, Charity.Protos.Charity.LoginUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoginUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.LoginUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.LoginUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("LoginUser"))
              .build();
        }
      }
    }
    return getLoginUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.GetCazuriRequest,
      Charity.Protos.Charity.GetCazuriResponse> getGetCazuriMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCazuri",
      requestType = Charity.Protos.Charity.GetCazuriRequest.class,
      responseType = Charity.Protos.Charity.GetCazuriResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.GetCazuriRequest,
      Charity.Protos.Charity.GetCazuriResponse> getGetCazuriMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.GetCazuriRequest, Charity.Protos.Charity.GetCazuriResponse> getGetCazuriMethod;
    if ((getGetCazuriMethod = CharityServiceGrpc.getGetCazuriMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getGetCazuriMethod = CharityServiceGrpc.getGetCazuriMethod) == null) {
          CharityServiceGrpc.getGetCazuriMethod = getGetCazuriMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.GetCazuriRequest, Charity.Protos.Charity.GetCazuriResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCazuri"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.GetCazuriRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.GetCazuriResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("GetCazuri"))
              .build();
        }
      }
    }
    return getGetCazuriMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.GetDonatorsRequest,
      Charity.Protos.Charity.GetDonatorsResponse> getGetDonatorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDonators",
      requestType = Charity.Protos.Charity.GetDonatorsRequest.class,
      responseType = Charity.Protos.Charity.GetDonatorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.GetDonatorsRequest,
      Charity.Protos.Charity.GetDonatorsResponse> getGetDonatorsMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.GetDonatorsRequest, Charity.Protos.Charity.GetDonatorsResponse> getGetDonatorsMethod;
    if ((getGetDonatorsMethod = CharityServiceGrpc.getGetDonatorsMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getGetDonatorsMethod = CharityServiceGrpc.getGetDonatorsMethod) == null) {
          CharityServiceGrpc.getGetDonatorsMethod = getGetDonatorsMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.GetDonatorsRequest, Charity.Protos.Charity.GetDonatorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDonators"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.GetDonatorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.GetDonatorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("GetDonators"))
              .build();
        }
      }
    }
    return getGetDonatorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonationRequest,
      Charity.Protos.Charity.OkResponse> getAddDonationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDonation",
      requestType = Charity.Protos.Charity.AddDonationRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonationRequest,
      Charity.Protos.Charity.OkResponse> getAddDonationMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonationRequest, Charity.Protos.Charity.OkResponse> getAddDonationMethod;
    if ((getAddDonationMethod = CharityServiceGrpc.getAddDonationMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getAddDonationMethod = CharityServiceGrpc.getAddDonationMethod) == null) {
          CharityServiceGrpc.getAddDonationMethod = getAddDonationMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.AddDonationRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDonation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.AddDonationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("AddDonation"))
              .build();
        }
      }
    }
    return getAddDonationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonatorRequest,
      Charity.Protos.Charity.OkResponse> getAddDonatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDonator",
      requestType = Charity.Protos.Charity.AddDonatorRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonatorRequest,
      Charity.Protos.Charity.OkResponse> getAddDonatorMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.AddDonatorRequest, Charity.Protos.Charity.OkResponse> getAddDonatorMethod;
    if ((getAddDonatorMethod = CharityServiceGrpc.getAddDonatorMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getAddDonatorMethod = CharityServiceGrpc.getAddDonatorMethod) == null) {
          CharityServiceGrpc.getAddDonatorMethod = getAddDonatorMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.AddDonatorRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDonator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.AddDonatorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("AddDonator"))
              .build();
        }
      }
    }
    return getAddDonatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateDonatorRequest,
      Charity.Protos.Charity.OkResponse> getUpdateDonatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDonator",
      requestType = Charity.Protos.Charity.UpdateDonatorRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateDonatorRequest,
      Charity.Protos.Charity.OkResponse> getUpdateDonatorMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateDonatorRequest, Charity.Protos.Charity.OkResponse> getUpdateDonatorMethod;
    if ((getUpdateDonatorMethod = CharityServiceGrpc.getUpdateDonatorMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getUpdateDonatorMethod = CharityServiceGrpc.getUpdateDonatorMethod) == null) {
          CharityServiceGrpc.getUpdateDonatorMethod = getUpdateDonatorMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.UpdateDonatorRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDonator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.UpdateDonatorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("UpdateDonator"))
              .build();
        }
      }
    }
    return getUpdateDonatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.AddCazCaritabilRequest,
      Charity.Protos.Charity.OkResponse> getAddCazCaritabilMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCazCaritabil",
      requestType = Charity.Protos.Charity.AddCazCaritabilRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.AddCazCaritabilRequest,
      Charity.Protos.Charity.OkResponse> getAddCazCaritabilMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.AddCazCaritabilRequest, Charity.Protos.Charity.OkResponse> getAddCazCaritabilMethod;
    if ((getAddCazCaritabilMethod = CharityServiceGrpc.getAddCazCaritabilMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getAddCazCaritabilMethod = CharityServiceGrpc.getAddCazCaritabilMethod) == null) {
          CharityServiceGrpc.getAddCazCaritabilMethod = getAddCazCaritabilMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.AddCazCaritabilRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCazCaritabil"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.AddCazCaritabilRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("AddCazCaritabil"))
              .build();
        }
      }
    }
    return getAddCazCaritabilMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateCazCaritabilRequest,
      Charity.Protos.Charity.OkResponse> getUpdateCazCaritabilMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCazCaritabil",
      requestType = Charity.Protos.Charity.UpdateCazCaritabilRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateCazCaritabilRequest,
      Charity.Protos.Charity.OkResponse> getUpdateCazCaritabilMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateCazCaritabilRequest, Charity.Protos.Charity.OkResponse> getUpdateCazCaritabilMethod;
    if ((getUpdateCazCaritabilMethod = CharityServiceGrpc.getUpdateCazCaritabilMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getUpdateCazCaritabilMethod = CharityServiceGrpc.getUpdateCazCaritabilMethod) == null) {
          CharityServiceGrpc.getUpdateCazCaritabilMethod = getUpdateCazCaritabilMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.UpdateCazCaritabilRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCazCaritabil"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.UpdateCazCaritabilRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("UpdateCazCaritabil"))
              .build();
        }
      }
    }
    return getUpdateCazCaritabilMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.LogoutUserRequest,
      Charity.Protos.Charity.OkResponse> getLogoutUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogoutUser",
      requestType = Charity.Protos.Charity.LogoutUserRequest.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.LogoutUserRequest,
      Charity.Protos.Charity.OkResponse> getLogoutUserMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.LogoutUserRequest, Charity.Protos.Charity.OkResponse> getLogoutUserMethod;
    if ((getLogoutUserMethod = CharityServiceGrpc.getLogoutUserMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getLogoutUserMethod = CharityServiceGrpc.getLogoutUserMethod) == null) {
          CharityServiceGrpc.getLogoutUserMethod = getLogoutUserMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.LogoutUserRequest, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogoutUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.LogoutUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("LogoutUser"))
              .build();
        }
      }
    }
    return getLogoutUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateResponse,
      Charity.Protos.Charity.OkResponse> getNotifyUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NotifyUpdate",
      requestType = Charity.Protos.Charity.UpdateResponse.class,
      responseType = Charity.Protos.Charity.OkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateResponse,
      Charity.Protos.Charity.OkResponse> getNotifyUpdateMethod() {
    io.grpc.MethodDescriptor<Charity.Protos.Charity.UpdateResponse, Charity.Protos.Charity.OkResponse> getNotifyUpdateMethod;
    if ((getNotifyUpdateMethod = CharityServiceGrpc.getNotifyUpdateMethod) == null) {
      synchronized (CharityServiceGrpc.class) {
        if ((getNotifyUpdateMethod = CharityServiceGrpc.getNotifyUpdateMethod) == null) {
          CharityServiceGrpc.getNotifyUpdateMethod = getNotifyUpdateMethod =
              io.grpc.MethodDescriptor.<Charity.Protos.Charity.UpdateResponse, Charity.Protos.Charity.OkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NotifyUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.UpdateResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Charity.Protos.Charity.OkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CharityServiceMethodDescriptorSupplier("NotifyUpdate"))
              .build();
        }
      }
    }
    return getNotifyUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CharityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CharityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CharityServiceStub>() {
        @java.lang.Override
        public CharityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CharityServiceStub(channel, callOptions);
        }
      };
    return CharityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CharityServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CharityServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CharityServiceBlockingV2Stub>() {
        @java.lang.Override
        public CharityServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CharityServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return CharityServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CharityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CharityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CharityServiceBlockingStub>() {
        @java.lang.Override
        public CharityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CharityServiceBlockingStub(channel, callOptions);
        }
      };
    return CharityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CharityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CharityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CharityServiceFutureStub>() {
        @java.lang.Override
        public CharityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CharityServiceFutureStub(channel, callOptions);
        }
      };
    return CharityServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void loginUser(Charity.Protos.Charity.LoginUserRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.LoginUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginUserMethod(), responseObserver);
    }

    /**
     */
    default void getCazuri(Charity.Protos.Charity.GetCazuriRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetCazuriResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCazuriMethod(), responseObserver);
    }

    /**
     */
    default void getDonators(Charity.Protos.Charity.GetDonatorsRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetDonatorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDonatorsMethod(), responseObserver);
    }

    /**
     */
    default void addDonation(Charity.Protos.Charity.AddDonationRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDonationMethod(), responseObserver);
    }

    /**
     */
    default void addDonator(Charity.Protos.Charity.AddDonatorRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDonatorMethod(), responseObserver);
    }

    /**
     */
    default void updateDonator(Charity.Protos.Charity.UpdateDonatorRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDonatorMethod(), responseObserver);
    }

    /**
     */
    default void addCazCaritabil(Charity.Protos.Charity.AddCazCaritabilRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCazCaritabilMethod(), responseObserver);
    }

    /**
     */
    default void updateCazCaritabil(Charity.Protos.Charity.UpdateCazCaritabilRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCazCaritabilMethod(), responseObserver);
    }

    /**
     */
    default void logoutUser(Charity.Protos.Charity.LogoutUserRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogoutUserMethod(), responseObserver);
    }

    /**
     */
    default void notifyUpdate(Charity.Protos.Charity.UpdateResponse request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNotifyUpdateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CharityService.
   * <pre>
   * Service definition
   * </pre>
   */
  public static abstract class CharityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CharityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CharityService.
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class CharityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CharityServiceStub> {
    private CharityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CharityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CharityServiceStub(channel, callOptions);
    }

    /**
     */
    public void loginUser(Charity.Protos.Charity.LoginUserRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.LoginUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCazuri(Charity.Protos.Charity.GetCazuriRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetCazuriResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCazuriMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDonators(Charity.Protos.Charity.GetDonatorsRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetDonatorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDonatorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDonation(Charity.Protos.Charity.AddDonationRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDonationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDonator(Charity.Protos.Charity.AddDonatorRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDonatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateDonator(Charity.Protos.Charity.UpdateDonatorRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDonatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCazCaritabil(Charity.Protos.Charity.AddCazCaritabilRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCazCaritabilMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCazCaritabil(Charity.Protos.Charity.UpdateCazCaritabilRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCazCaritabilMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logoutUser(Charity.Protos.Charity.LogoutUserRequest request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogoutUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void notifyUpdate(Charity.Protos.Charity.UpdateResponse request,
        io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNotifyUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CharityService.
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class CharityServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CharityServiceBlockingV2Stub> {
    private CharityServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CharityServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CharityServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public Charity.Protos.Charity.LoginUserResponse loginUser(Charity.Protos.Charity.LoginUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.GetCazuriResponse getCazuri(Charity.Protos.Charity.GetCazuriRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCazuriMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.GetDonatorsResponse getDonators(Charity.Protos.Charity.GetDonatorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDonatorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addDonation(Charity.Protos.Charity.AddDonationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDonationMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addDonator(Charity.Protos.Charity.AddDonatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDonatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse updateDonator(Charity.Protos.Charity.UpdateDonatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDonatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addCazCaritabil(Charity.Protos.Charity.AddCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCazCaritabilMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse updateCazCaritabil(Charity.Protos.Charity.UpdateCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCazCaritabilMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse logoutUser(Charity.Protos.Charity.LogoutUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogoutUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse notifyUpdate(Charity.Protos.Charity.UpdateResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNotifyUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CharityService.
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class CharityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CharityServiceBlockingStub> {
    private CharityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CharityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CharityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Charity.Protos.Charity.LoginUserResponse loginUser(Charity.Protos.Charity.LoginUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.GetCazuriResponse getCazuri(Charity.Protos.Charity.GetCazuriRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCazuriMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.GetDonatorsResponse getDonators(Charity.Protos.Charity.GetDonatorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDonatorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addDonation(Charity.Protos.Charity.AddDonationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDonationMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addDonator(Charity.Protos.Charity.AddDonatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDonatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse updateDonator(Charity.Protos.Charity.UpdateDonatorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDonatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse addCazCaritabil(Charity.Protos.Charity.AddCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCazCaritabilMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse updateCazCaritabil(Charity.Protos.Charity.UpdateCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCazCaritabilMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse logoutUser(Charity.Protos.Charity.LogoutUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogoutUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Charity.Protos.Charity.OkResponse notifyUpdate(Charity.Protos.Charity.UpdateResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNotifyUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CharityService.
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class CharityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CharityServiceFutureStub> {
    private CharityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CharityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CharityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.LoginUserResponse> loginUser(
        Charity.Protos.Charity.LoginUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.GetCazuriResponse> getCazuri(
        Charity.Protos.Charity.GetCazuriRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCazuriMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.GetDonatorsResponse> getDonators(
        Charity.Protos.Charity.GetDonatorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDonatorsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> addDonation(
        Charity.Protos.Charity.AddDonationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDonationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> addDonator(
        Charity.Protos.Charity.AddDonatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDonatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> updateDonator(
        Charity.Protos.Charity.UpdateDonatorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDonatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> addCazCaritabil(
        Charity.Protos.Charity.AddCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCazCaritabilMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> updateCazCaritabil(
        Charity.Protos.Charity.UpdateCazCaritabilRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCazCaritabilMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> logoutUser(
        Charity.Protos.Charity.LogoutUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogoutUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Charity.Protos.Charity.OkResponse> notifyUpdate(
        Charity.Protos.Charity.UpdateResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNotifyUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_USER = 0;
  private static final int METHODID_GET_CAZURI = 1;
  private static final int METHODID_GET_DONATORS = 2;
  private static final int METHODID_ADD_DONATION = 3;
  private static final int METHODID_ADD_DONATOR = 4;
  private static final int METHODID_UPDATE_DONATOR = 5;
  private static final int METHODID_ADD_CAZ_CARITABIL = 6;
  private static final int METHODID_UPDATE_CAZ_CARITABIL = 7;
  private static final int METHODID_LOGOUT_USER = 8;
  private static final int METHODID_NOTIFY_UPDATE = 9;

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
        case METHODID_LOGIN_USER:
          serviceImpl.loginUser((Charity.Protos.Charity.LoginUserRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.LoginUserResponse>) responseObserver);
          break;
        case METHODID_GET_CAZURI:
          serviceImpl.getCazuri((Charity.Protos.Charity.GetCazuriRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetCazuriResponse>) responseObserver);
          break;
        case METHODID_GET_DONATORS:
          serviceImpl.getDonators((Charity.Protos.Charity.GetDonatorsRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.GetDonatorsResponse>) responseObserver);
          break;
        case METHODID_ADD_DONATION:
          serviceImpl.addDonation((Charity.Protos.Charity.AddDonationRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_ADD_DONATOR:
          serviceImpl.addDonator((Charity.Protos.Charity.AddDonatorRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_UPDATE_DONATOR:
          serviceImpl.updateDonator((Charity.Protos.Charity.UpdateDonatorRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_ADD_CAZ_CARITABIL:
          serviceImpl.addCazCaritabil((Charity.Protos.Charity.AddCazCaritabilRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CAZ_CARITABIL:
          serviceImpl.updateCazCaritabil((Charity.Protos.Charity.UpdateCazCaritabilRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_LOGOUT_USER:
          serviceImpl.logoutUser((Charity.Protos.Charity.LogoutUserRequest) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
          break;
        case METHODID_NOTIFY_UPDATE:
          serviceImpl.notifyUpdate((Charity.Protos.Charity.UpdateResponse) request,
              (io.grpc.stub.StreamObserver<Charity.Protos.Charity.OkResponse>) responseObserver);
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
          getLoginUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.LoginUserRequest,
              Charity.Protos.Charity.LoginUserResponse>(
                service, METHODID_LOGIN_USER)))
        .addMethod(
          getGetCazuriMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.GetCazuriRequest,
              Charity.Protos.Charity.GetCazuriResponse>(
                service, METHODID_GET_CAZURI)))
        .addMethod(
          getGetDonatorsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.GetDonatorsRequest,
              Charity.Protos.Charity.GetDonatorsResponse>(
                service, METHODID_GET_DONATORS)))
        .addMethod(
          getAddDonationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.AddDonationRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_ADD_DONATION)))
        .addMethod(
          getAddDonatorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.AddDonatorRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_ADD_DONATOR)))
        .addMethod(
          getUpdateDonatorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.UpdateDonatorRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_UPDATE_DONATOR)))
        .addMethod(
          getAddCazCaritabilMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.AddCazCaritabilRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_ADD_CAZ_CARITABIL)))
        .addMethod(
          getUpdateCazCaritabilMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.UpdateCazCaritabilRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_UPDATE_CAZ_CARITABIL)))
        .addMethod(
          getLogoutUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.LogoutUserRequest,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_LOGOUT_USER)))
        .addMethod(
          getNotifyUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Charity.Protos.Charity.UpdateResponse,
              Charity.Protos.Charity.OkResponse>(
                service, METHODID_NOTIFY_UPDATE)))
        .build();
  }

  private static abstract class CharityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CharityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Charity.Protos.Charity.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CharityService");
    }
  }

  private static final class CharityServiceFileDescriptorSupplier
      extends CharityServiceBaseDescriptorSupplier {
    CharityServiceFileDescriptorSupplier() {}
  }

  private static final class CharityServiceMethodDescriptorSupplier
      extends CharityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CharityServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CharityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CharityServiceFileDescriptorSupplier())
              .addMethod(getLoginUserMethod())
              .addMethod(getGetCazuriMethod())
              .addMethod(getGetDonatorsMethod())
              .addMethod(getAddDonationMethod())
              .addMethod(getAddDonatorMethod())
              .addMethod(getUpdateDonatorMethod())
              .addMethod(getAddCazCaritabilMethod())
              .addMethod(getUpdateCazCaritabilMethod())
              .addMethod(getLogoutUserMethod())
              .addMethod(getNotifyUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
