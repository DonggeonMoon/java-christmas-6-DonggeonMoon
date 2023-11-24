# 🎄 크리스마스 프로모션

## 📋 기능 목록

| 구분    | 기능                    | 책임                                          | 비고 |
|-------|-----------------------|---------------------------------------------|----|
| 입출력   | 이벤트 플래너 메시지 출력        | ChristmasOutputView                         |    |
| 입출력   | 방문 날짜 입력 프롬프트 출력      | ChristmasInputView                          |    |
| 입출력   | 예상 방문 날짜 입력           | ChristmasInputView                          |    |
| 객체 생성 | 방문 날짜 생성              | ChristmasService, VisitDate                 |    |
| 검증    | 예상 방문 날짜 검증           | VisitDate                                   |    |
| 객체 생성 | 예상 방문 날짜 DTO 생성       | ChristmasService, VisitDate                 |    |
| 입출력   | 주문할 메뉴, 개수 입력 프롬프트 출력 | ChristmasInputView                          |    |
| 입출력   | 주문할 메뉴, 개수 입력         | ChristmasInputView                          |    |
| 객체 생성 | 주문 메뉴 객체 생성           | ChristmasService, Order                     |    |
| 검증    | 주문할 메뉴, 개수 검증         | Order                                       |    |
| 변환    | 주문 메뉴 DTO 객체 생성       | ChristmasService, OrderDto                  |    |
| 입출력   | 이벤트 혜택 미리보기 메시지 출력    | ChristmasOutputView                         |    |
| 입출력   | 주문 메뉴 출력              | ChristmasOutputView                         |    |
| 객체 생성 | 할인 전 총주문 금액 객체 생성     | ChristmasService, PreDiscountAmount         |    |
| 변환    | 할인 전 총주문 금액 DTO 객체 생성 | ChristmasService, PreDiscountAmountDto      |    |
| 입출력   | 할인 전 총주문 금액 출력        | ChristmasOutputView                         |    |
| 객체 생성 | 혜택들 객체 생성             | ChristmasService, Benefits                  |    |
| 변환    | 혜택들 DTO 객체 생성         | ChristmasService, BenefitDto                |    |
| 객체 생성 | 증정 메뉴 객체 생성           | ChristmasService, Order, GiveAwayMenu       |    |
| 변환    | 증정 메뉴 DTO 객체 생성       | ChristmasService, GiveAwayMenuDto           |    |
| 입출력   | 증정 메뉴 출력              | ChristmasOutputView                         |    |
| 입출력   | 혜택 내역 출력              | ChristmasOutputView                         |    |
| 객체 생성 | 총혜택 금액 객체 생성          | ChristmasService, Order, TotalBenefitAmount |    |
| 변환    | 총혜택 금액 DTO 객체 생성      | ChristmasService, TotalBenefitAmountDto     |    |
| 입출력   | 총혜택 금액 출력             | ChristmasOutputView                         |    |
| 객체 생성 | 할인 후 결제 금액 객체 생성      | ChristmasService, PostDiscountAmount        |    |
| 변환    | 할인 후 결제 금액 DTO 객체 생성  | ChristmasService, PostDiscountAmountDto     |    |
| 입출력   | 할인 후 결제 금액 출력         | ChristmasOutputView                         |    |
| 객체 생성 | 배지 객체 생성              | ChristmasService, EventBadge                |    |
| 변환    | 배지 DTO 객체 생성          | ChristmasService, EventBadgeDto             |    |
| 입출력   | 배지 출력                 | ChristmasOutputView                         |    |

## ⛔예외 상황

* 방문 날짜가 숫자가 아닌 경우
* 방문 날짜가 1~31 범위가 아닌 경우
* 메뉴가 `메뉴명-숫자` 형식이 아닌 경우
* 메뉴가 1이상의 숫자가 아닌 경우
* 메뉴 총개수가 20개 이상인 경우
* 중복 메뉴 입력 시
* 음료만 주문 시