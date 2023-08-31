# 😏AppleMarket
#### 중고거래 앱 당근마켓을 클론코딩한 사과마켓 앱 입니다.
#### [사과마켓 blog] 🔗 <https://velog.io/@ouowinnie/appleMarketAppLast>

<div><h3>✔ UI, Spinner</h3></div>

![intro](https://github.com/ouowinnie/AppleMarket/assets/139089298/a71824e8-ed13-46d1-89a6-25beb95ec3a1)

<br>

드롭다운 형식의 선택 목록을 표시하는 UI로, 터치하면 선택할 수 있는 항목들이 리스트로 표시되며 이 중 하나의 항목을 선택할 수 있습니다. 당근동에서 사과동으로 동네 설정을 변경했습니다.

<div><h3>✔ Floatingactionbutton</h3></div>

![main](https://github.com/ouowinnie/AppleMarket/assets/139089298/8af3986b-cee7-4c07-adec-32d0afa6efa6)

<br>

작업이나 동작을 강조하는 데 사용되며, 화면의 오른쪽 또는 왼쪽 하단에 부착되어 사용자가 쉽게 접근할 수 있습니다. 버튼을 누르면 화면 최상단으로 이동합니다.

<div><h3>✔ onBackPressed()</h3></div>

![sub](https://github.com/ouowinnie/AppleMarket/assets/139089298/dbb16bf7-148b-4ed6-b447-9deb361e3377)

<br>

기본적으로 화면에서 뒤로 가기 버튼을 누르면 onBackPressed() 메서드가 호출되어 현재 화면을 종료하고 이전 화면으로 돌아가게 됩니다. 이 앱에서는 종료 다이얼로그 메세지와 함께 앱 종료 여부를 묻습니다.

<div><h3>✔ Notification</h3></div>

![sub](https://github.com/ouowinnie/AppleMarket/assets/139089298/6d9306bc-784e-4ad8-84ca-dc2f2661b5ce)

<br>

앱에서 사용자에게 알림을 보여주는 기능입니다. 종 모양 아이콘을 누르면 상태바에 설정해놓은 아이콘 표시가 뜨며, 알림을 확인할 수 있습니다.

<div><h3>✔ back, like, LongItemClick</h3></div>

![sub](https://github.com/ouowinnie/AppleMarket/assets/139089298/c58f99d6-8c97-4559-a855-7a719ef71791)

<br>
상세페이지 좌측 상단 뒤로가기 버튼 클릭시 메인 엑티비티로 전환되며, 상세페이지는 종료됩니다. 좋아요 버튼을 누르면 아이콘이 토글됩니다. 아이템 롱클릭 이벤트가 발생하면 AlertDialog가 생성됩니다. 확인 버튼을 누르면 removeItem(position) 함수가 호출되어 해당 아이템을 삭제하고 어댑터에게 변경 사항을 알립니다.