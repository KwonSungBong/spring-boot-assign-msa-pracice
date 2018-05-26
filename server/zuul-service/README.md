# zuul-service

https://github.com/anthofo/spring-boot-security-oauth2-jwt

#키생성
keytool -genkey -alias zuulServiceKey -keyalg RSA -keystore keystore.jks -storepass zuulServicePassword -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US"

#허용
curl localhost:8095/test

#토큰요청
curl zuulService:zuulServiceSecret@localhost:8095/oauth/token -d grant_type=password -d username=user -d password=password

#토큰설정해서 요청
curl -H "Authorization: Bearer [access_token]" localhost:8095/user


curl -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjczODgzOTksInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJVU0VSIl0sImp0aSI6ImMzYTVlNjBjLTRjYjgtNDlmZS1iZDAzLTVjZjRhNmUzZmUxMiIsImNsaWVudF9pZCI6Inp1dWxTZXJ2aWNlIiwic2NvcGUiOlsib3BlbmlkIl19.Up44UP-LXA7CnA0sjqQn0V0bmlfSGDDplmt3YyHfxQndmrl6bDG01GuIuBpzRq0TruGCNJe9emoRrtIj-mP2DFQZyjKfJG1viVRwHkNQSK86UkfrKpwnW-a77JhArJGLmX4Db0Ohz6OZnogp-ssH5C-z9wOEsWU9yKXJBzuVgRk_k-spVk3yT0_8oxOCs-cl3gQDO_aL5UI2IcxV20Uq6Q5SkqlXZzV2LIQDAgzrhzz7RXrex-_jqH84NCfwc19pnrLIV2668nq4eZ3ylNDrZiqnRyi2-1n9BZt7HwSuJ68peUO2mKYdQ-0A1_8-99E-aCMHIC6Ui51bbtKD-QeMjw" localhost:8095/me/user

