# :one: 서비스 소개
### 서비스명 : 심포니 (symphony)
### 서비스 한 줄 소개 : 일상을 '음표'로 기록하고 '악보'로 만나보세요

#  :two: 개발 담당 부분
#### [최유리](https://github.com/uxri) : 작곡자 등록 뷰 (SetNameActivity)
#### [김효림](https://github.com/KxxHyoRim) : 악보 뷰 (SymphonyActivity)
#### [정지연](https://github.com/stopkite) : 글쓰기 뷰(PostNoteActivtiy)
#### 공통: 일기 읽기 뷰 (ShowNoteDialog)

#  :three: 코드 컨벤션
## 1. Kotlin Naming Convention

### 1.1. Class
클래스 파일 이름은 UpperCamelCase를 따른다.

#### 1.1.1. Prefix
- Prefix는 해당 클래스와 관련성이 높은 것으로 임의로 작성한다.
##### - EXAMPLE
`MainActivity`  
`SymphonyFragment`

### 1.2. Variable
변수 이름은 lowerCamelCase를 따른다.
##### - EXAMPLE
`viewPagerAdapter`

----

## 2. Resource Naming Convention
### 2.1. ID
View 이름 Pascal Case를 축약하여 Snake Case로 변환한 것을 따르도록 한다.

#### 2.1.1. Prefix
`<WHAT>_<DESCRIPTION>`

|View|Prefix|
|:---:|:---:|
|ImageView|`iv_`|
|TextView|`tv_`|
|EditText|`et`|
|Button, ImageButton|`btn_`|
|RecyclerView|`rv_`|
|Layout|`layout_`|
|FragmentContainerView|`fcv_`|  

##### - EXAMPLE
```xml
@+id/tv_name
@+id/et_title
@+id/btn_complete
```

### 2.2. Layout
Layout의 xml 파일의 이름은 .kt 의 Pascal Case를 Snake Case로 변환하여 사용한다.

#### 2.2.1. Prefix
`<WHAT>_<WHERE>`

|View|Prefix|
|:---:|:---:|
|Activity|`activity_`|
|Fragment|`fragment_`|
|Dialog|`dialog_`|
|Item|`item_`|

##### - EXAMPLE
`SignInActivity.kt` -> `activity_sign_in.xml`  
`SignUpFragment.kt` -> `fragment_sign_up.xml`
`item_user.xml`

### 2.3. Drawable
#### 2.3.1. Prefix
`<WHAT_DESCRIPTION>`

|Drawable|Prefix|
|:---:|:---:|
|Icon|`ic_`|
|Image|`img_`|
|Background|`bg_`|
|Shape|`<shape>_<color>_<radius>_<value>`|

##### - EXAMPLE
```
ic_error.xml
img_default_user.xml
bg_main.xml
rectangle_yellow_radius_20.xml
```

### 2.4. Color
Color의 이름은 Snake Case로 정한다.

##### - EXAMPLE
```xml
<color name="black">#FF000000</color>
<color name="main_blue">#FFFFFFFF</color>
```




#  :four: 브랜치 전략
### main
#### 기준이 되는 브랜치로 최종 작업물을 PR하는 브랜치

### feature/화면명
#### 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 main 브랜치에 Merge
##### ex) feature/set-name