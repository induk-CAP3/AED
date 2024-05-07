import React from 'react';
import { NaverMap, Marker, Container } from 'react-naver-maps'; // 필요한 컴포넌트를 임포트

function NaverMapComponent() {
  // 환경변수에서 Client ID 가져오기
  const ncpClientId = process.env.REACT_APP_NCP_CLIENT_ID; // 환경변수에서 Client ID 가져오기

  console.log('NCP Client ID:', ncpClientId); // 콘솔로 Client ID 확인

  return (
    <Container style={{width: '100%', height: '400px'}}>
      <NaverMap
        ncpClientId={ncpClientId} // 환경 변수를 올바르게 참조
        style={{ width: '100%', height: '100%' }}
        defaultCenter={{ lat: 37.5666103, lng: 126.9783882 }}
        defaultZoom={15}
      >
        <Marker position={{ lat: 37.5666103, lng: 126.9783882 }} />
      </NaverMap>
    </Container>
  );
}

export default NaverMapComponent;
