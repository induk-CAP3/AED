import React, { useState, useEffect } from 'react';
import { NaverMap, Marker, useNavermaps } from 'react-naver-maps';

function NApiMap() {
  const navermaps = useNavermaps();
  const [myLocation, setMyLocation] = useState({ latitude: null, longitude: null });
  const [isMapLoading, setIsMapLoading] = useState(true);

  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(success, error);
    }

    function success(position) {
      setMyLocation({
        latitude: position.coords.latitude,
        longitude: position.coords.longitude
      });
      setIsMapLoading(false);
    }

    function error() {
      console.error('사용자 위치 불러오기 실패');
      setMyLocation({ latitude: 37.4979517, longitude: 127.0276188 }); // 기본 위치 설정
      setIsMapLoading(false);
    }
  }, []);

  return (
    <NaverMap
      defaultCenter={new navermaps.LatLng(myLocation.latitude, myLocation.longitude)}
      defaultZoom={15}
    >
      <Marker
        defaultPosition={new navermaps.LatLng(myLocation.latitude, myLocation.longitude)}
      />
    </NaverMap>
  );
}

export default NApiMap;
