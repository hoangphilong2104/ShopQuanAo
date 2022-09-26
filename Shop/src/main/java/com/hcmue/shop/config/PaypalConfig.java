package com.hcmue.shop.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

//@Configuration
public class PaypalConfig {
	

	@Value("AdEAgIlkgs8Lkr7uqGyeUSokqVj5ws7IklGiy48LX5Z7-cADnZq-XN_lcvo3xXR8mROwTRT8JFAaxhaC")
	private String clientId;
	@Value("EO94csniqz926R2fo8yZa7LgAaEyeA8MLkDOW-s1iL8DZBmIl0gdIqd-pW-3_i-aFQ2pNK5jJ7JXFKsA")
	private String clientSecret;
	@Value("sandbox")
	private String mode;
	
	@Bean
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> configMap = new HashMap<>();
		configMap.put("mode", mode);
		return configMap;
	}

	@Bean
	public OAuthTokenCredential oAuthTokenCredential() {
		return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
	}

	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
		context.setConfigurationMap(paypalSdkConfig());
		return context;
	}
}
