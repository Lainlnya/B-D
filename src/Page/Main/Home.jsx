import { useState } from 'react';
import styled from './Home.module.css';
import InfoBox from '../../Component/Common/InfoBox';
import Card from '../../Asset/Image/HOME_icons/card-dynamic-color.png';
import Coin from '../../Asset/Image/HOME_icons/Coins.png';
import LinkFront from '../../Asset/Image/HOME_icons/link-front-color.png';
import Locker from '../../Asset/Image/HOME_icons/locker-dynamic-color.png';
import Clock from '../../Asset/Image/HOME_icons/clock-front-color.png';
import Calendar from '../../Asset/Image/HOME_icons/calender-dynamic-color.png';
import useModal from '../../hooks/useModal';
import TimeTable from '../../Component/Common/TimeTable';

export default function Home() {
  const { openModal } = useModal();
  const dumpData = [
    { name: '이승헌', coupon: '청소 역할 선점 쿠폰' },
    { name: '이현진', coupon: '급식 먼저 먹기 쿠폰' },
    { name: '배민지', coupon: '10분 노래 틀기 쿠폰' },
    { name: '배미남', coupon: '자유 이용 쿠폰' },
  ];

  return (
    <>
      <main className={styled.home}>
        <button className={styled.holdBtn}>
          <span className={styled.hold}>HOLD</span>
          <span className={styled.holdInfo}>지금은 경매가 진행되고 있어요</span>
        </button>
        <InfoBox
          info={[
            {
              width: '30vw',
              height: '15vh',
              text: ['승인할 쿠폰이', '있어요.'],
            },
          ]}
          icons={[{ src: Card, alt: '카드', css: 'card' }]}
          text={'7건'}
          modalClick={() =>
            openModal({ type: 'coupon', props: ['쿠폰 신청 목록', dumpData] })
          }
        />
        <section className={styled.secondRow}>
          <section className={styled.graphSec}></section>
          <section className={styled.infoSec}>
            <InfoBox
              info={[
                {
                  width: '30vw',
                  height: '15vh',
                  text: ['현재 학생들은 주급으로', '를 받아요'],
                },
              ]}
              icons={[{ src: Coin, alt: '주급', css: 'coin' }]}
              text={'200비드'}
              modalClick={() =>
                openModal({
                  type: 'changeBid',
                  props: ['주급 변경', '200비드'],
                })
              }
            />
            <InfoBox
              info={[
                {
                  width: '30vw',
                  height: '15vh',
                  text: ['오늘 우리반은', '의 거래를 했어요!'],
                },
              ]}
              icons={[{ src: LinkFront, alt: '거래', css: 'linkFront' }]}
              text={'15건'}
            />
          </section>
        </section>
        <section className={styled.thirdRow}>
          <section className={styled.infoSec}>
            <InfoBox
              info={[
                {
                  width: '35vw',
                  height: '15vh',
                  text: ['현재 국고에는', '있어요'],
                },
              ]}
              icons={[{ src: Locker, alt: '국고', css: 'locker' }]}
              text={'1,839,500비드'}
            />
            <InfoBox
              info={[
                {
                  width: '35vw',
                  height: '15vh',
                  text: ['적금 알림은', '에 발송돼요'],
                },
              ]}
              icons={[{ src: Clock, alt: '시계', css: 'clock' }]}
              text={'8:00'}
              modalClick={() =>
                openModal({
                  type: 'intoMoney',
                  props: ['적금 시간 변경', dumpData],
                })
              }
            />
          </section>
          <section className={styled.schedule}>
            <TimeTable />
          </section>
        </section>
      </main>
    </>
  );
}
