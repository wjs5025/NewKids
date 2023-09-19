import React from 'react';
import { ReactComponent as Logo } from 'assets/imgs/newkids-logo.svg';
import SearchBar from 'components/atoms/common/SearchBar';
import Button from 'components/atoms/common/Button';
import useMovePage from 'hooks/useMovePage';
import { NavBarContainer } from './style';

export function AuthNavBar() {
	const [movePage] = useMovePage();

	return (
		<NavBarContainer $auth>
			<div className="logo auth-navbar">
				<Logo onClick={() => movePage('/index')} />
			</div>
		</NavBarContainer>
	);
}

function NavBar() {
	const [movePage] = useMovePage();

	return (
		<NavBarContainer>
			<div className="logo">
				<Logo onClick={() => movePage('/index')} />
			</div>
			<div className="search-bar">
				<SearchBar size="l" confirmSearch={() => {}} />
			</div>
			<Button size="s" radius="l" color="Primary" text="로그인" handleClick={() => movePage('/auth/login')} />
		</NavBarContainer>
	);
}

export default NavBar;
