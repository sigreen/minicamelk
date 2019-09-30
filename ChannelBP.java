import org.apache.camel.builder.RouteBuilder;

//kamel run ChannelBP.java --dev

public class ChannelBP extends RouteBuilder {  

  @Override
  public void configure() throws Exception {
    from("knative:channel/bloodpressure")
    .log("--> BP ${body}");



  }


}
