<template>
    <b-form @submit="onSubmit">
        <b-container fluid>
            <b-row class="justify-content-md-center">
                <b-col sm="7">
                    <b-form-input id="input-large" type="text" v-model="userName" size="lg" trim placeholder="이름(필수)"></b-form-input>
                </b-col>
            </b-row>
            <b-row class="justify-content-md-center">
                <b-col sm="7">
                    <b-form-input id="input-large" type="text" v-model="phoneNo" size="lg" trim placeholder="휴대폰번호(필수)"></b-form-input>
                </b-col>
            </b-row>
            <b-row class="justify-content-md-center">
                <b-col sm="7">
                    <b-form-input id="input-large" type="text" v-model="email" size="lg" trim placeholder="이메일(선택)"></b-form-input>
                </b-col>
            </b-row>
            <b-row>
                <b-col sm="12">
                    <b-form-group>
                        <b-form-radio size="lg" v-model="selected" name="some-radios" value="Y">동의합니다<span style="color:red;">(필수)</span></b-form-radio>
                        <b-form-radio size="lg" v-model="selected" name="some-radios" value="N">동의하지 않습니다(웹세미나 참여가 불가합니다)</b-form-radio>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col sm="12">
                    <b-form-group >
                        <b-form-checkbox-group
                            id="checkbox-seminar_yn"
                            v-model="seminarYn"
                            name="flavour-2"
                            size="lg"
                        >
                            <b-form-checkbox value="Y">한국투자신탁운용의 웹세미나 자동신청(선택)</b-form-checkbox>
                        </b-form-checkbox-group>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row class="justify-content-md-center">
                <b-col>
                    <b-button size="lg" type="submit" variant="success">신청하기</b-button>
                </b-col>
            </b-row>
            <img src="../../assets/main.png">
        </b-container>
    </b-form>
</template>

<script>

import { user_register } from '@/api/user'

export default {
  name : 'event',
  data() {
    return {
        selected: '',
        seminarYn: [],
        userName: '',
        phoneNo: '',
        email: ''
    }
  },
  methods: {
    onSubmit() {
        user_register(this.userName, this.phoneNo, this.email, this.seminarYn)
    }
  }
}
</script>