//package main.java.practice.httpconnect;
//
//import com.ezcred.adapters.lenders.kotak.data.KotakApacReversalRequest;
//import com.ezcred.adapters.lenders.kotak.data.KotakApacReversalResponse;
//import com.ezcred.adapters.lenders.kotak.data.KotakGenericLoanPORequest;
//import com.ezcred.adapters.lenders.kotak.data.KotakGenericLoanRequest;
//import com.ezcred.adapters.lenders.kotak.data.KotakGenericLoanResponse;
//import io.reactivex.Observable;
//import retrofit2.http.Body;
//import retrofit2.http.Header;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//
//public interface SampleGateway {
//
//  String CONTENT_TYPE_APPLICATION_XML = "Content-Type: application/xml";
//  String API_KEY = "apikey";
//  String COLON = ":";
//
//  String PURPOSE_ELIGIBILITY = "ELIGIBILITY";
//  String PURPOSE_VALIDATION_AND_LOAN_BOOKING = "VALIDATION_AND_LOAN_BOOKING";
//  String PURPOSE_CANCELLATION = "CANCELLATION";
//  String REQUEST_PURPOSE_HEADER_CANCELLATION =
//      REQUEST_PURPOSE_HEADER + COLON + PURPOSE_CANCELLATION;
//  String REQUEST_PURPOSE_HEADER_ELIGIBILITY = REQUEST_PURPOSE_HEADER + COLON + PURPOSE_ELIGIBILITY;
//  String REQUEST_PURPOSE_HEADER_VALIDATION_AND_LOAN_BOOKING =
//      REQUEST_PURPOSE_HEADER + COLON + PURPOSE_VALIDATION_AND_LOAN_BOOKING;
//
//  @POST("EligibilityCheckAPI")
//  @Headers(
//      {
//          CONTENT_TYPE_APPLICATION_XML,
//          REQUEST_PURPOSE_HEADER_ELIGIBILITY
//      }
//  )
//  Observable<KotakGenericLoanResponse> getGLSPreOtp(
//      @Header(LOAN_ID_HEADER) Long loanId,
//      @Body KotakGenericLoanRequest kotakGenericLoanRequest
//  );
//
//  @POST("ValidationAndLoanBookingAPI")
//  @Headers(
//      {
//          CONTENT_TYPE_APPLICATION_XML,
//          REQUEST_PURPOSE_HEADER_VALIDATION_AND_LOAN_BOOKING
//      }
//  )
//  Observable<KotakGenericLoanResponse> getGLSPostOtp(
//      @Header(LOAN_ID_HEADER) Long loanId,
//      @Header(API_KEY) String apiKey,
//      @Body KotakGenericLoanPORequest kotakGenericLoanPORequest
//  );
//
//  @POST("CancellationLoanAPI")
//  @Headers(
//      {
//          CONTENT_TYPE_APPLICATION_XML,
//          REQUEST_PURPOSE_HEADER_CANCELLATION
//      }
//  )
//  Observable<KotakApacReversalResponse> getApacReversal(
//      @Header(LOAN_ID_HEADER) Long loanId,
//      @Header(API_KEY) String apiKey,
//      @Body KotakApacReversalRequest kotakApacReversalRequest
//  );
//}
//
