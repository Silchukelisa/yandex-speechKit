package syandex.cloud.api.ai.tts.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: speechkit.proto")
public final class SynthesizerGrpc {

  private SynthesizerGrpc() {}

  public static final String SERVICE_NAME = "speechkit.tts.v3.Synthesizer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest,
      syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> getUtteranceSynthesisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UtteranceSynthesis",
      requestType = syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest.class,
      responseType = syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest,
      syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> getUtteranceSynthesisMethod() {
    io.grpc.MethodDescriptor<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest, syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> getUtteranceSynthesisMethod;
    if ((getUtteranceSynthesisMethod = SynthesizerGrpc.getUtteranceSynthesisMethod) == null) {
      synchronized (SynthesizerGrpc.class) {
        if ((getUtteranceSynthesisMethod = SynthesizerGrpc.getUtteranceSynthesisMethod) == null) {
          SynthesizerGrpc.getUtteranceSynthesisMethod = getUtteranceSynthesisMethod =
              io.grpc.MethodDescriptor.<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest, syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UtteranceSynthesis"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SynthesizerMethodDescriptorSupplier("UtteranceSynthesis"))
              .build();
        }
      }
    }
    return getUtteranceSynthesisMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SynthesizerStub newStub(io.grpc.Channel channel) {
    return new SynthesizerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SynthesizerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SynthesizerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SynthesizerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SynthesizerFutureStub(channel);
  }

  /**
   */
  public static abstract class SynthesizerImplBase implements io.grpc.BindableService {

    /**
     */
    public void utteranceSynthesis(syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest request,
        io.grpc.stub.StreamObserver<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUtteranceSynthesisMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUtteranceSynthesisMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest,
                syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse>(
                  this, METHODID_UTTERANCE_SYNTHESIS)))
          .build();
    }
  }

  /**
   */
  public static final class SynthesizerStub extends io.grpc.stub.AbstractStub<SynthesizerStub> {
    private SynthesizerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SynthesizerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynthesizerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SynthesizerStub(channel, callOptions);
    }

    /**
     */
    public void utteranceSynthesis(syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest request,
        io.grpc.stub.StreamObserver<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUtteranceSynthesisMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SynthesizerBlockingStub extends io.grpc.stub.AbstractStub<SynthesizerBlockingStub> {
    private SynthesizerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SynthesizerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynthesizerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SynthesizerBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse> utteranceSynthesis(
        syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getUtteranceSynthesisMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SynthesizerFutureStub extends io.grpc.stub.AbstractStub<SynthesizerFutureStub> {
    private SynthesizerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SynthesizerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SynthesizerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SynthesizerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_UTTERANCE_SYNTHESIS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SynthesizerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SynthesizerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UTTERANCE_SYNTHESIS:
          serviceImpl.utteranceSynthesis((syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisRequest) request,
              (io.grpc.stub.StreamObserver<syandex.cloud.api.ai.tts.v3.Speechkit.UtteranceSynthesisResponse>) responseObserver);
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

  private static abstract class SynthesizerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SynthesizerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return syandex.cloud.api.ai.tts.v3.Speechkit.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Synthesizer");
    }
  }

  private static final class SynthesizerFileDescriptorSupplier
      extends SynthesizerBaseDescriptorSupplier {
    SynthesizerFileDescriptorSupplier() {}
  }

  private static final class SynthesizerMethodDescriptorSupplier
      extends SynthesizerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SynthesizerMethodDescriptorSupplier(String methodName) {
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
      synchronized (SynthesizerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SynthesizerFileDescriptorSupplier())
              .addMethod(getUtteranceSynthesisMethod())
              .build();
        }
      }
    }
    return result;
  }
}
