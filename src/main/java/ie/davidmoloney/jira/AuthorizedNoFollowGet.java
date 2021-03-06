package ie.davidmoloney.jira;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

public class AuthorizedNoFollowGet extends NoFollowGet {

    public AuthorizedNoFollowGet(ConnectionDetails connectionDetails, String relativeUri) {
        super(connectionDetails.getBaseUri() + relativeUri);
        setHeader(createAuthorizationHeader(connectionDetails.getUser(), connectionDetails.getPassword()));
    }

    public Header createAuthorizationHeader( String username, String password ) {
        StringBuilder authorizationValue = new StringBuilder();
        authorizationValue.append("Basic ");
        Base64Encoder encoder = new Base64Encoder();
        String encodedUserPassCombo = encoder.encode(username, password);
        authorizationValue.append(encodedUserPassCombo);
        return new BasicHeader(HttpHeaders.AUTHORIZATION, authorizationValue.toString());
    }



}

//class AuthorizationHeader extends BasicHeader {
//    AuthorizationHeader(String username, String password) {
//        //super(HttpHeaders.A);
//
//    }
//}
