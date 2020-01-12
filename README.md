# warikan

[j5ik2o/warikan-domain](https://github.com/j5ik2o/warikan-domain)

## モデル

![割り勘ドメイン](https://user-images.githubusercontent.com/58995947/72217602-a55bf600-3573-11ea-9921-47b2dee570fd.png)

## 実行方法

`bootRun` で起動後に localhost:8080 にアクセスすると Swagger-ui 画面に遷移します。

### 飲み会を予定する

- まずは飲み会を予定してください。

- 飲み会の予定には以下 2 つのパラメータを指定します。

  - 飲み会の名前
  - 飲み会の開催日時

- 飲み会の予定が完了すると `飲み会 ID` が払い出されます。他の API を実行する際に必要になるのでメモしておいてください。

### 幹事を登録する

- 続いて上で予定した飲み会の幹事を登録してください。

- 幹事の登録には以下 3 つのパラメータを指定します。

  - 飲み会 ID: 上で払い出された値
  - 幹事の名前
  - 支払い区分: `plus` または `default` または `minus`

- 登録が完了すると `メンバ ID` が払い出されます。他の API の実行には使用しないのでメモは不要です。

### 参加者を登録する

- 続いて参加者を登録します。

- 参加者の登録には以下 3 つのパラメータを指定します。

  - 飲み会 ID: 上で払い出された値
  - 参加者の名前
  - 支払い区分: `plus` または `default` または `minus`

- 追加が完了すると `メンバ ID` が払い出されます。幹事の時と同じ理由でメモは不要です。

### 請求書を発行する

- 最後に請求書を発行します。

- 請求書の発行には以下 2 つのパラメータを指定します。

  - 飲み会 ID: 上で払い出された値
  - 請求金額合計

- 発行が完了すると、各メンバの請求金額の一覧と不足金額を返します。

  - 各メンバへは 500 円単位で請求します。
  - 例えば 20000 円を 3 人（支払い区分は全員同じとする）に請求する場合、各メンバへの請求金額は 6500 円、不足金額は 500 円になります。
  - 不足金額は偉い人に払ってもらう想定です。偉い人がいない場合は話し合いで払う人を決めます