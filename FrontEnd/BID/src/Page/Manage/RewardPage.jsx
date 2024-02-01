import React from "react";
import styled from "./RewardPage.module.css";
import SubmitButton from "../../Component/Common/SubmitButton";

export default function RewardPage() {
  return (
    <div className = {styled.contentSection}>
      <div className = {styled.rewardArea}>
        <div className = {[styled.studentCol, styled.col].join(" ")}>
          <h3 className = {styled.title}> 학생 목록 </h3>
          <table>
            <thead>
              <tr>
                <th><input type='checkbox' /></th>
                <th>번호</th>
                <th>이름</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><input type='checkbox' /></td>
                <td>1</td>
                <td>봇봇봇</td>
              </tr>
              <tr>
                <td><input type='checkbox' /></td>
                <td>2</td>
                <td>옷옷옷</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div className = {[styled.rewardCol, styled.col].join(" ")}>
          <div className = {styled.header}>
            <h3 className = {styled.title}> 리워드 목록 </h3>
            <button type="button"> 리워드 편집 </button>
          </div>
          <div className = {styled.rewardContainer}>
            <div className = {styled.body}>
              <div className = {styled.reward}>
                <span>우리반 멋쟝이 포항항</span>
                <span>100비드</span>
              </div>
            </div>
            <div className = {styled.footer}>
              <form onSubmit=''>
                <input
                  type='text'
                  placeholder='리워드 이름'
                />
                <input
                  type='number'
                  placeholder='금액'
                />
                <SubmitButton
                  text = '추가'
                  width = '4vw'
                  height = '4vw'
                  fontSize = '1.3vw'
                />
              </form>
            </div>
          </div>
        </div>
        <div className = {[styled.submitCol, styled.col].join(" ")}>
          <div className = {styled.result}>
            <div className = {styled.student}>
              <h3 className = {styled.subTitle}> 리워드 대상 </h3>
              <div className = {styled.body}>
                <div>가가가</div>
                <div>나나나</div>
                <div>다다다</div>
                <div>라라라</div>
                <div>마마마</div>
              </div>
            </div>
            <div className = {styled.reward}>
              <h3 className = {styled.subTitle}> 지급 리워드 </h3>
              <div className = {styled.body}>우리 반 환경 지킴이</div>
            </div>
          </div>
          <div className = {styled.comment}>
              <h3 className = {styled.title}> 코멘트 </h3>
              <textarea/>
          </div>
          <SubmitButton
            text = '리워드 지급'
            width = '10vw'
            height = '5vw'
            fontSize = '2vw'
          />
        </div>
      </div>
    </div>
  );
}
